package eu.siacs.conversations.crypto.sasl;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;

import eu.siacs.conversations.entities.Account;

public class ScramSha256 extends ScramMechanism {

    public static final String MECHANISM = "SCRAM-SHA-256";

    public ScramSha256(final Account account) {
        super(account, ChannelBinding.NONE);
    }

    @Override
    protected HMac getHMAC() {
        return new HMac(new SHA256Digest());
    }

    @Override
    protected Digest getDigest() {
        return new SHA256Digest();
    }

    @Override
    public int getPriority() {
        return 25;
    }

    @Override
    public String getMechanism() {
        return MECHANISM;
    }
}
