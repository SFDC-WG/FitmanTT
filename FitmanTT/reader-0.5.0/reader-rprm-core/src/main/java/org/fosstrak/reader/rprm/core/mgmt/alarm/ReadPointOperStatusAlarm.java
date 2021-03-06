/*
 * Copyright (C) 2007 ETH Zurich
 *
 * This file is part of Fosstrak (www.fosstrak.org).
 *
 * Fosstrak is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1, as published by the Free Software Foundation.
 *
 * Fosstrak is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Fosstrak; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package org.fosstrak.reader.rprm.core.mgmt.alarm;

import org.fosstrak.reader.rprm.core.ReaderDevice;
import org.fosstrak.reader.rprm.core.mgmt.OperationalStatus;

/**
 * <code>ReadPointOperStatusAlarm</code> extends the
 * <code>TTOperStatusAlarm</code> class. Its receipt signals a change in the
 * operational status of one of a Reader's Read Points. The abstract model's
 * <code>ReadPoint.operStatusAlarmControl</code> data element controls the
 * triggering of alarms of this type.
 */
public class ReadPointOperStatusAlarm extends TTOperStatusAlarm {

	/**
	 * The name of the Read Point that experienced the alarm-triggering state
	 * transition, i.e., the value of the respective <code>ReadPoint.name</code>
	 * model element.
	 */
	private String readPointName;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            The name of the alarm identifying the type of alarm, e.g.,
	 *            "ReadPointOperStatusAlarm"
	 * @param alarmLevel
	 *            The severity level of the alarm
	 * @param readerDevice
	 *            The reader device
	 * @param fromState
	 *            The originating <code>OperationalStatus</code> of the Read
	 *            Point before the <code>Alarm</code> is generated
	 * @param toState
	 *            The <code>OperationalStatus</code> at the time the
	 *            <code>Alarm</code> is generated
	 * @param readPointName
	 *            The name of the read point
	 */
	public ReadPointOperStatusAlarm(String name, AlarmLevel alarmLevel,
			ReaderDevice readerDevice, OperationalStatus fromState,
			OperationalStatus toState, String readPointName) {
		super(name, alarmLevel, readerDevice, fromState, toState);
		this.readPointName = readPointName;
	}

	/**
	 * Returns the name of the Read Point that experienced the alarm-triggering
	 * state transition, i.e., the value of the respective
	 * <code>ReadPoint.name</code> model element.
	 * 
	 * @return The name of the <code>ReadPoint</code>
	 */
	public String getReadPointName() {
		return readPointName;
	}

}
