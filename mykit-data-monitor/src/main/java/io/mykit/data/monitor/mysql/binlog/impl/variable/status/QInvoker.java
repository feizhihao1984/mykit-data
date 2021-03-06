package io.mykit.data.monitor.mysql.binlog.impl.variable.status;


import io.mykit.data.monitor.mysql.common.glossary.column.StringColumn;
import io.mykit.data.monitor.mysql.common.util.MySQLConstants;
import io.mykit.data.monitor.mysql.common.util.ToStringBuilder;
import io.mykit.data.monitor.mysql.io.XInputStream;

import java.io.IOException;

public class QInvoker extends AbstractStatusVariable {
    public static final int TYPE = MySQLConstants.Q_INVOKER;

    private final StringColumn user;
    private final StringColumn host;

    public QInvoker(StringColumn user, StringColumn host) {
        super(TYPE);
        this.user = user;
        this.host = host;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("user", user)
                .append("host", host).toString();
    }

    public StringColumn getUser() {
        return user;
    }

    public StringColumn getHost() {
        return host;
    }

    public static QInvoker valueOf(XInputStream tis) throws IOException {
        final int userLength = tis.readInt(1);
        final StringColumn user = tis.readFixedLengthString(userLength);
        final int hostLength = tis.readInt(1);
        final StringColumn host = tis.readFixedLengthString(hostLength);
        return new QInvoker(user, host);
    }
}
