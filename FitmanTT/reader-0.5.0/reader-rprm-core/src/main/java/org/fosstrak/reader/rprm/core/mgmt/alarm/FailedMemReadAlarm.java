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

import org.fosstrak.reader.rprm.core.AntennaReadPoint;
import org.fosstrak.reader.rprm.core.ReaderDevice;

/**
 * <code>FailedMemReadAlarm</code> extends the <code>Alarm</code> class. Its
 * receipt signals a tag user-memory read failure. The abstract model's
 * <code>AntennaReadPoint.failedMemReadAlarmControl</code> data element
 * controls the triggering of alarms of this type.
 */
public class FailedMemReadAlarm extends Alarm {

	/**
	 * The name of the read point (an <code>AntennaReadPoint</code>) over
	 * which the memory read failure occurred.
	 */
	private String readPointName;

	/**
	 * The value of <code>AntennaReadPoint.failedMemReadCount</code> element
	 * after the memory read failure occurred.
	 */
	private int failedMemReadCount;

	/**
	 * The value of the <code>AntennaReadPoint.noiseLevel</code> element when
	 * the memory read failure occurred.
	 */
	private int noiseLevel;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            The name of the alarm identifying the type of alarm, e.g.,
	 *            "FailedMemReadAlarm"
	 * @param alarmLevel
	 *            The severity level of the alarm
	 * @param readerDevice
	 *            The reader device
	 * @param readPoint
	 *            The <code>AntennaReadPoint</code> over which the memory read
	 *            failure occured
	 */
	public FailedMemReadAlarm(String name, AlarmLevel alarmLevel,
			ReaderDevice readerDevice, AntennaReadPoint readPoint) {
		super(name, alarmLevel, readerDevice);
		readPointName = readPoint.getName();
		failedMemReadCount = readPoint.getFailedMemReadCount();
		noiseLevel = readPoint.getNoiseLevel();
	}

	/**
	 * Returns the name of the read point (an <code>AntennaReadPoint</code>)
	 * over which the memory read failure occurred.
	 * 
	 * @return The name of the <code>ReadPoint</code>
	 */
	public String getReadPointName() {
		return readPointName;
	}

	/**
	 * Returns the value of <code>AntennaReadPoint.failedMemReadCount</code>
	 * element after the memory read failure occurred.
	 * 
	 * @return The <code>failedMemReadCount</code> for the
	 *         <code>ReadPoint</code>
	 */
	public int getFailedMemReadCount() {
		return failedMemReadCount;
	}

	/**
	 * Returns the value of the <code>AntennaReadPoint.noiseLevel</code>
	 * element when the memory read failure occurred.
	 * 
	 * @return The <code>noiseLevel</code> for the <code>ReadPoint</code>
	 */
	public int getNoiseLevel() {
		return noiseLevel;
	}

}
