# SFDC (Shop Floor data Collection)
SFDC is a collection of modules i.e. Fitman Tag&Trace (FitmanT&T) and Fitman Sensor Networks (FitmanSN) - which can be deployed and used independently; for data acquisition from the shop floor making use of smart objects, in the scope of Internet of Things-oriented Manufacturing Ecosystems. 
This Specific enabler is based on open source projects like [Fosstrak][1] and [GSN][2] and it is provided as independent binaries to be deployed and used independently


## FitmanTT
This component is based on the open source project Fosstrak. Fosstrak is an open source integrated software platform for the management of the RFID readers and the corresponding events and data where the major software components and tools are web-based. Fosstrak implements the EPC Global Specs. This component is responsible for collection of data from objects in the shop floor with RFID tags.

## FitmanSN
This component is based on Global Sensors Network (GSN) which is the outcome of OpenIoT project. GSN is a middleware (extendible software infrastructure) for rapid deployment and integration of heterogeneous wireless sensor networks. The modules of GSN for data acquisition are utilized in this component.

Readme, how to install GSN can be found here:
* [SFDC-WG/FitmanSN/README.md] [PlDb]

### Licence
GPL v3  Licence

  [1]: http://fosstrak.github.io/
  [2]: http://sourceforge.net/apps/trac/gsn/
  [PlDb]: <https://github.com/SFDC-WG/FitmanSN/blob/master/readme>