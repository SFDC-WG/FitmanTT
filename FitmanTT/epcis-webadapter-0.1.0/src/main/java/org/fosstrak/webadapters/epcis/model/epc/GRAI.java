/*
 * Copyright (C) 2010 ETH Zurich
 *
 * This file is part of Fosstrak (www.fosstrak.org) and
 * was developed as part of the webofthings.com initiative.
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
package org.fosstrak.webadapters.epcis.model.epc;

import org.fosstrak.webadapters.epcis.config.Config;
import org.fosstrak.webadapters.epcis.model.Entry;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Global Reusable Asset Identifier
 * @author Mathias Mueller
 * mathias.mueller(at)unifr.ch
 *
 */
@XmlRootElement(namespace = "fosstrak.org/epcis/restadapter")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class GRAI implements EPC {

    public static final String NAME = "Global Reusable Asset Identifier";
    public static final String ID   = GRAI_PREFIX;
    private String             epc;
    private String             companyPrefix;
    private String             assetType;
    private String             serialNumber;

    /**
     * Constructs Global Reusable Asset Identifier
     *
     *
     * @param epc
     */
    public GRAI(String epc) {
        this.epc = epc;
        initEPC();
    }

    private void initEPC() {
        String part[] = epc.split("\\.");

        if (part.length == 3) {
            companyPrefix = part[0];
            assetType     = part[1];
            serialNumber  = part[2];
        }
    }

    /**
     * Get a list of the components of this EPC
     *
     *
     * @return
     */
    @XmlElement(name = "component")
    public List<Entry> getComponents() {
        List<Entry> res    = new ArrayList<Entry>();

        Entry       entry1 = new Entry();
        Entry       entry2 = new Entry();
        Entry       entry3 = new Entry();

        entry1.setName(COMPANY_PREFIX);
        entry1.setValue(companyPrefix);
        entry1.setValueRef(ID + companyPrefix + "." + Config.STAR);

        entry2.setName(ASSET_TYPE);
        entry2.setValue(assetType);
        entry2.setValueRef(ID + companyPrefix + "." + assetType + "." + Config.STAR);

        entry3.setName(SERIAL_NUMBER);
        entry3.setValue(serialNumber);
        entry3.setValueRef(ID + companyPrefix + "." + assetType + "." + serialNumber);

        if (entry1.getValue() != null) {
            res.add(entry1);
        }

        if (entry2.getValue() != null) {
            res.add(entry2);
        }

        if (entry3.getValue() != null) {
            res.add(entry3);
        }

        return res;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getName() {
        return NAME;
    }
}
