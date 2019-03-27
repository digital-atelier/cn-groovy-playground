import groovy.xml.QName

def parser = new XmlParser()

// read from file 
def ServiceManifest = new XmlParser().parse(new File('ServiceManifest.xml'))

def EnvironmentVariable = parser.createNode(
    null,
    new QName("EnvironmentVariable"),
    [:]
)
EnvironmentVariable.value = 'test'

ServiceManifest.CodePackage.EnvironmentVariables[0].children().add(0, EnvironmentVariable)

println ServiceManifest.CodePackage.EnvironmentVariables.EnvironmentVariable.text()

FileWriter fileWriter = new FileWriter('save_file.xml')
XmlNodePrinter nodePrinter = new XmlNodePrinter(new PrintWriter(fileWriter))

nodePrinter.setPreserveWhitespace(true)
nodePrinter.print(ServiceManifest)
