package io.mykit.data.monitor.mysql.binlog.impl.event;


import io.mykit.data.monitor.mysql.binlog.BinlogEventV4Header;
import io.mykit.data.monitor.mysql.common.glossary.Pair;
import io.mykit.data.monitor.mysql.common.glossary.Row;
import io.mykit.data.monitor.mysql.common.glossary.UnsignedLong;
import io.mykit.data.monitor.mysql.common.glossary.column.BitColumn;
import io.mykit.data.monitor.mysql.common.util.MySQLConstants;
import io.mykit.data.monitor.mysql.common.util.ToStringBuilder;

import java.util.List;

/**
 * Used for row-based binary logging. This event logs updates of rows in a single table.
 */
public final class UpdateRowsEvent extends AbstractRowEvent {
    public static final int EVENT_TYPE = MySQLConstants.UPDATE_ROWS_EVENT;

    private UnsignedLong columnCount;
    private BitColumn usedColumnsBefore;
    private BitColumn usedColumnsAfter;
    private List<Pair<Row>> rows;

    public UpdateRowsEvent() {
    }

    public UpdateRowsEvent(BinlogEventV4Header header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("header", header)
                .append("tableId", tableId)
                .append("reserved", reserved)
                .append("columnCount", columnCount)
                .append("usedColumnsBefore", usedColumnsBefore)
                .append("usedColumnsAfter", usedColumnsAfter)
                .append("rows", rows).toString();
    }

    public UnsignedLong getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(UnsignedLong columnCount) {
        this.columnCount = columnCount;
    }

    public BitColumn getUsedColumnsBefore() {
        return usedColumnsBefore;
    }

    public void setUsedColumnsBefore(BitColumn usedColumnsBefore) {
        this.usedColumnsBefore = usedColumnsBefore;
    }

    public BitColumn getUsedColumnsAfter() {
        return usedColumnsAfter;
    }

    public void setUsedColumnsAfter(BitColumn usedColumnsAfter) {
        this.usedColumnsAfter = usedColumnsAfter;
    }

    public List<Pair<Row>> getRows() {
        return rows;
    }

    public void setRows(List<Pair<Row>> rows) {
        this.rows = rows;
    }
}
