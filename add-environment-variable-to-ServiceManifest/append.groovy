import groovy.xml.QName

def parser = new XmlParser()

// read from file 
def ServiceManifest = new XmlParser().parse(new File('ServiceManifest.xml'))

// create node
def EnvironmentVariable = parser.createNode(
    null,
    new QName("EnvironmentVariable"),
    [:]
)
EnvironmentVariable.value = 'test'

// add node 
ServiceManifest.CodePackage.EnvironmentVariables.add(0, EnvironmentVariable)
