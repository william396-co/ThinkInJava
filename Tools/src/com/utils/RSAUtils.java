package com.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;
import org.springframework.util.Assert;

import javax.crypto.Cipher;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

public abstract class RSAUtils {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    private static final int KEY_SIZE = 4096;
    private static final int MAX_DECRYPT_BLOCK = 128;
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final Provider PROVIDER = new BouncyCastleProvider();

    public RSAUtils() {
    }

    public static final String getBase64Modulus(RSAPublicKey publicKey) {
        String base64 = Base64.encodeBase64String(publicKey.getModulus().toByteArray());
        return org.apache.commons.lang.StringUtils.replace(base64, "\r\n", "");
    }

    public static final String getBase64Exponent(RSAPublicKey publicKey) {
        String base64 = Base64.encodeBase64String(publicKey.getPublicExponent().toByteArray());
        return StringUtils.replace(base64, "\r\n", "");
    }

    public static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", PROVIDER);
            keyPairGenerator.initialize(4096, new SecureRandom());
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException var1) {
            var1.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(PublicKey publicKey, byte[] data) {
        Assert.notNull(publicKey);
        Assert.notNull(data);

        try {
            Cipher cipher = Cipher.getInstance("RSA", PROVIDER);
            cipher.init(1, publicKey);
            return cipher.doFinal(data);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static String encrypt(PublicKey publicKey, String text) {
        Assert.notNull(publicKey);
        Assert.notNull(text);
        byte[] data = encrypt(publicKey, text.getBytes());
        return data != null ? Base64.encodeBase64String(data) : null;
    }

    public static byte[] decrypt(PrivateKey privateKey, byte[] data) {
        Assert.notNull(privateKey);
        Assert.notNull(data);

        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", PROVIDER);
            cipher.init(2, privateKey);
            return cipher.doFinal(data);
        } catch (Exception var3) {
            return null;
        }
    }

    public static String decrypt(PrivateKey privateKey, String text) {
        Assert.notNull(privateKey);
        Assert.notNull(text);
        byte[] data = decrypt(privateKey, Base64.decodeBase64(text));
        return data != null ? new String(data) : null;
    }

    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(1, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * 117) {
            byte[] cache;
            if (inputLen - offSet > 117) {
                cache = cipher.doFinal(data, offSet, 117);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(2, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * 128) {
            byte[] cache;
            if (inputLen - offSet > 128) {
                cache = cipher.doFinal(encryptedData, offSet, 128);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(1, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * 117) {
            byte[] cache;
            if (inputLen - offSet > 117) {
                cache = cipher.doFinal(data, offSet, 117);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(2, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * 128) {
            byte[] cache;
            if (inputLen - offSet > 128) {
                cache = cipher.doFinal(encryptedData, offSet, 128);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    public static String toString(RSAPrivateKey privateKey) {
        StringBuilder sb = new StringBuilder();
        sb.append(privateKey.getModulus());
        sb.append("\n");
        sb.append(privateKey.getPrivateExponent());
        return sb.toString();
    }

    public static X509Certificate generateX509Certificate(String c, String st, String l, String o, String cn, KeyPair kp) {
        try {
            X500Name issuer = new X500Name(String.format("C=%s,ST=%s,L=%s,O=%s,CN=%s", c, st, l, o, cn));
            X509v3CertificateBuilder builder = new JcaX509v3CertificateBuilder(issuer, BigInteger.valueOf(System.currentTimeMillis()), new Date(System.currentTimeMillis() - 3600000L), new Date(System.currentTimeMillis() + 315360000000L), issuer, kp.getPublic());
            X509CertificateHolder holder = builder.build((new JcaContentSignerBuilder("SHA1WithRSA")).setProvider(PROVIDER).build(kp.getPrivate()));
            X509Certificate cert = (new JcaX509CertificateConverter()).setProvider(PROVIDER).getCertificate(holder);
            cert.checkValidity(new Date());
            cert.verify(kp.getPublic());
            PKCS12BagAttributeCarrier bagAttr = (PKCS12BagAttributeCarrier)cert;
            bagAttr.setBagAttribute(PKCSObjectIdentifiers.pkcs_9_at_friendlyName, new DERBMPString(cn));
            return cert;
        } catch (OperatorCreationException var11) {
            throw new RuntimeException(var11);
        } catch (CertificateException var12) {
            throw new RuntimeException(var12);
        } catch (NoSuchAlgorithmException var13) {
            throw new RuntimeException(var13);
        } catch (InvalidKeyException var14) {
            throw new RuntimeException(var14);
        } catch (NoSuchProviderException var15) {
            throw new RuntimeException(var15);
        } catch (SignatureException var16) {
            throw new RuntimeException(var16);
        }
    }

    public static KeyStore generatePfx(String c, String st, String l, String o, String cn, KeyPair kp, String alias, String password) {
        try {
            X500Name issuer = new X500Name(String.format("C=%s,ST=%s,L=%s,O=%s,CN=%s", c, st, l, o, cn));
            X509v3CertificateBuilder builder = new JcaX509v3CertificateBuilder(issuer, BigInteger.valueOf(System.currentTimeMillis()), new Date(System.currentTimeMillis() - 3600000L), new Date(System.currentTimeMillis() + 315360000000L), issuer, kp.getPublic());
            X509CertificateHolder holder = builder.build((new JcaContentSignerBuilder("SHA256WithRSAEncryption")).setProvider(PROVIDER).build(kp.getPrivate()));
            X509Certificate cert = (new JcaX509CertificateConverter()).setProvider(PROVIDER).getCertificate(holder);
            cert.checkValidity(new Date());
            cert.verify(kp.getPublic());
            PKCS12BagAttributeCarrier bagAttr = (PKCS12BagAttributeCarrier)cert;
            bagAttr.setBagAttribute(PKCSObjectIdentifiers.pkcs_9_at_friendlyName, new DERBMPString(cn));
            KeyStore store = KeyStore.getInstance("PKCS12");
            store.load((InputStream)null, (char[])null);
            store.setKeyEntry(alias, kp.getPrivate(), password.toCharArray(), new Certificate[]{cert});
            return store;
        } catch (OperatorCreationException var14) {
            throw new RuntimeException(var14);
        } catch (CertificateException var15) {
            throw new RuntimeException(var15);
        } catch (NoSuchAlgorithmException var16) {
            throw new RuntimeException(var16);
        } catch (InvalidKeyException var17) {
            throw new RuntimeException(var17);
        } catch (NoSuchProviderException var18) {
            throw new RuntimeException(var18);
        } catch (SignatureException var19) {
            throw new RuntimeException(var19);
        } catch (KeyStoreException var20) {
            throw new RuntimeException(var20);
        } catch (IOException var21) {
            throw new RuntimeException(var21);
        }
    }

    public static void write(X509Certificate cert, OutputStream stream) {
        PemWriter pw = null;

        try {
            pw = new PemWriter(new OutputStreamWriter(stream));
            pw.writeObject(new PemObject("CERTIFICATE", cert.getEncoded()));
        } catch (CertificateEncodingException var8) {
            throw new RuntimeException(var8);
        } catch (IOException var9) {
            throw new RuntimeException(var9);
        } finally {
            IOUtils.closeQuietly(pw);
        }

    }

    public static void write(KeyStore store, String password, OutputStream stream) {
        try {
            store.store(stream, password.toCharArray());
        } catch (CertificateException var4) {
            throw new RuntimeException(var4);
        } catch (NoSuchAlgorithmException var5) {
            throw new RuntimeException(var5);
        } catch (KeyStoreException var6) {
            throw new RuntimeException(var6);
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }
    }

    public static RSAPublicKey getRSAPublicKey(BigInteger modulus, BigInteger publicExponent) {
        try {
            return (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(modulus, publicExponent));
        } catch (GeneralSecurityException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static Object[] loadKeyFromKeyStore(byte[] buffer, String password) {
        ByteArrayInputStream bis = null;

        Object[] var5;
        try {
            bis = new ByteArrayInputStream(buffer);
            KeyStore store = KeyStore.getInstance("PKCS12");
            store.load(bis, password.toCharArray());
            String alias = (String)store.aliases().nextElement();
            var5 = new Object[]{store.getCertificate(alias), store.getKey(alias, password.toCharArray())};
        } catch (KeyStoreException var13) {
            throw new RuntimeException(var13);
        } catch (CertificateException var14) {
            throw new RuntimeException(var14);
        } catch (NoSuchAlgorithmException var15) {
            throw new RuntimeException(var15);
        } catch (IOException var16) {
            throw new RuntimeException(var16);
        } catch (UnrecoverableKeyException var17) {
            throw new RuntimeException(var17);
        } finally {
            IOUtils.closeQuietly(bis);
        }

        return var5;
    }

    public static final byte[] sign4b(PrivateKey privateKey, byte[] data, String algorithm) {
        try {
            Signature signature = Signature.getInstance(algorithm);
            signature.initSign(privateKey);
            signature.update(data);
            return signature.sign();
        } catch (NoSuchAlgorithmException var4) {
            throw new RuntimeException(var4);
        } catch (InvalidKeyException var5) {
            throw new RuntimeException(var5);
        } catch (SignatureException var6) {
            throw new RuntimeException(var6);
        }
    }

    public static final String sign(PrivateKey privateKey, byte[] data, String algorithm) {
        try {
            return new String(Base64.encodeBase64(sign4b(privateKey, data, algorithm)), "utf-8");
        } catch (UnsupportedEncodingException var4) {
            throw new RuntimeException(var4);
        }
    }

    public static final boolean validateSign(PublicKey publicKey, byte[] data, byte[] signed, String algorithm) {
        try {
            Signature signature = Signature.getInstance(algorithm);
            signature.initVerify(publicKey);
            signature.update(data);
            return signature.verify(signed);
        } catch (NoSuchAlgorithmException var5) {
            throw new RuntimeException(var5);
        } catch (InvalidKeyException var6) {
            throw new RuntimeException(var6);
        } catch (SignatureException var7) {
            throw new RuntimeException(var7);
        }
    }

    public static String sign(String content, String privateKey) throws Exception {
        PrivateKey priKey = toPrivateKey(privateKey);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(priKey);
        signature.update(content.getBytes(Charset.forName("UTF-8")));
        byte[] signed = signature.sign();
        String signStr = Base64.encodeBase64String(signed);
        return signStr;
    }

    public static boolean verifySign(String content, String sign, String public_key) throws Exception {
        PublicKey pubKey = toPublicKey(public_key);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(pubKey);
        signature.update(content.getBytes(Charset.forName("UTF-8")));
        boolean bverify = signature.verify(Base64.decodeBase64(sign));
        return bverify;
    }

    public static PrivateKey toPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static PublicKey toPublicKey(String key) throws Exception {
        byte[] keyByte = Base64.decodeBase64(key);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyByte);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        return publicKey;
    }

    public static final void main(String[] args) throws IOException {
        String password = "123456";
        KeyPair kp = generateKeyPair();
        FileOutputStream fs = null;
        FileOutputStream pfs = null;

        try {
            fs = new FileOutputStream("/Users/sihai/Downloads/public.cer");
            write(generateX509Certificate("CN", "Zhejiang", "Hanzhou", "opentech.com", "uqiantu.net", kp), fs);
            fs.flush();
            fs.close();
            pfs = new FileOutputStream("/Users/sihai/Downloads/private.pfx");
            write(generatePfx("CN", "Zhejiang", "Hanzhou", "opentech.com", "uqiantu.net", kp, "qiantu.net", password), password, pfs);
            pfs.flush();
            pfs.close();
        } finally {
            IOUtils.closeQuietly(fs);
            IOUtils.closeQuietly(pfs);
        }

    }

    static {
        Security.addProvider(PROVIDER);
    }
}