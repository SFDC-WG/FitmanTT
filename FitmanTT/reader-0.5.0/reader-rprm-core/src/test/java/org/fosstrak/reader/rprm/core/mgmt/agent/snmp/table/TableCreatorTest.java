package org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table ;

import junit.framework.TestCase;

import org.fosstrak.reader.rprm.core.ReaderDevice;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.SnmpAgent;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table.SnmpTable;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table.TableCreator;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.table.SnmpTable.TableTypeEnum;
import org.fosstrak.reader.rprm.core.msg.MessageLayer;
import org.apache.log4j.xml.DOMConfigurator;
import org.snmp4j.agent.DefaultMOServer;

/**
 * Tests for the class <code>org.fosstrak.reader.mgmt.agent.snmp.table.TableCreator</code>.
 */
public class TableCreatorTest extends TestCase {

	/**
	 * TableCreator instance.
	 */
	private TableCreator tableCreator;

	private ReaderDevice readerDevice;
	private DefaultMOServer server;

	/**
	 * Sets up the test.
	 * @exception Exception An error occurred
	 */
	protected final void setUp() throws Exception {
		super.setUp();

		DOMConfigurator.configure("./target/classes/props/log4j.xml");

		if (SnmpAgent.getInstance() == null) {
			MessageLayer.main(new String[] { });
		}

		readerDevice = ReaderDevice.getInstance();

		server = new DefaultMOServer();

		tableCreator = new TableCreator(server, readerDevice);
	}

	/**
	 * Does the cleanup.
	 * @exception Exception An error occurred
	 */
	protected final void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Tests the <code>createTable()</code> method.
	 */
	public final void testCreateTable() {
		SnmpTable table;

		table = tableCreator.createTable(TableTypeEnum.EPCG_GLOBAL_COUNTERS_TABLE);
		assertEquals(TableTypeEnum.EPCG_GLOBAL_COUNTERS_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_READER_SERVER_TABLE);
		assertEquals(TableTypeEnum.EPCG_READER_SERVER_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_READ_POINT_TABLE);
		assertEquals(TableTypeEnum.EPCG_READ_POINT_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_ANT_READ_POINT_TABLE);
		assertEquals(TableTypeEnum.EPCG_ANT_READ_POINT_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_IO_PORT_TABLE);
		assertEquals(TableTypeEnum.EPCG_IO_PORT_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_SOURCE_TABLE);
		assertEquals(TableTypeEnum.EPCG_SOURCE_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_NOTIFICATION_CHANNEL_TABLE);
		assertEquals(TableTypeEnum.EPCG_NOTIFICATION_CHANNEL_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_TRIGGER_TABLE);
		assertEquals(TableTypeEnum.EPCG_TRIGGER_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_NOTIF_TRIG_TABLE);
		assertEquals(TableTypeEnum.EPCG_NOTIF_TRIG_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_READ_TRIG_TABLE);
		assertEquals(TableTypeEnum.EPCG_READ_TRIG_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_RD_PNT_SRC_TABLE);
		assertEquals(TableTypeEnum.EPCG_RD_PNT_SRC_TABLE, table.getType());

		table = tableCreator.createTable(TableTypeEnum.EPCG_NOTIF_CHAN_SRC_TABLE);
		assertEquals(TableTypeEnum.EPCG_NOTIF_CHAN_SRC_TABLE, table.getType());
	}

	/**
	 * Runs the test using the gui runner.
	 * @param args No arguments
	 */
	public static void main(String[] args) {
        junit.swingui.TestRunner.run(TableCreatorTest.class);
    }

}
