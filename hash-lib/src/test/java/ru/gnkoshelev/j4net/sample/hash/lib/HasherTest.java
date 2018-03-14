package ru.gnkoshelev.j4net.sample.hash.lib;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kgn on 13.03.2018.
 */
public class HasherTest {
    @Test(expected = RuntimeException.class)
    public void testUnknownAlgorithm() {
        Hasher.compute("NON_EXISTING_ALGORITHM", new byte[]{0x00});
    }

    @Test
    public void testSha512() {
        String hash = Hasher.compute("SHA-512", new byte[] {'a'});
        Assert.assertEquals(
                "1F40FC92DA241694750979EE6CF582F2D5D7D28E18335DE05ABC54D0560E0F5302860C652BF08D560252AA5E74210546F369FBBBCE8C12CFC7957B2652FE9A75",
                hash);
    }

    @Test
    public void testMd5() {
        String hash = Hasher.compute("MD5", new byte[] {'a'});
        Assert.assertEquals(
                "0CC175B9C0F1B6A831C399E269772661",
                hash);
    }
}
