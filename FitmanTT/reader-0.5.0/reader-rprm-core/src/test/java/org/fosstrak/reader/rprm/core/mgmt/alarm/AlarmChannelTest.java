package org.fosstrak.reader.rprm.core.mgmt.alarm;

import java.net.MalformedURLException;

import junit.framework.TestCase;

import org.fosstrak.reader.rprm.core.ReaderDevice;
import org.fosstrak.reader.rprm.core.ReaderProtocolException;
import org.fosstrak.reader.rprm.core.mgmt.agent.snmp.SnmpAgent;
import org.fosstrak.reader.rprm.core.mgmt.alarm.AlarmChannel;
import org.fosstrak.reader.rprm.core.msg.Address;
import org.fosstrak.reader.rprm.core.msg.MessageLayer;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Tests for the class <code>org.fosstrak.reader.mgmt.alarm.AlarmChannel</code>.
 */
public class AlarmChannelTest extends TestCase {

	private ReaderDevice readerDevice;

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
	}

	/**
	 * Does the cleanup.
	 * @exception Exception An error occurred
	 */
	protected final void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Tests the <code>create()</code> method.
	 */
	public final void testCreate() {
		String name = "TestAlarmChannel";
		int alarmChanCount = readerDevice.getAllAlarmChannels().length;
		try {
			AlarmChannel alarmChannel = AlarmChannel.create(name, new Address("udp://127.0.0.1:162"), readerDevice);
			assertEquals(alarmChanCount + 1, readerDevice.getAllAlarmChannels().length);
			readerDevice.removeAlarmChannels(new AlarmChannel[] { alarmChannel });
		} catch (ReaderProtocolException rpe) {
			assertEquals(alarmChanCount, readerDevice.getAllAlarmChannels().length);
		} catch (MalformedURLException mue) {
			fail();
		}
	}

	/**
	 * Runs the test using the gui runner.
	 * @param args No arguments
	 */
	public static void main(String[] args) {
        junit.swingui.TestRunner.run(AlarmChannelTest.class);
    }

}
