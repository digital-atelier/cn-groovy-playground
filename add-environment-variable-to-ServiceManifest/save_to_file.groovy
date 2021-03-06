import groovy.xml.QName
import groovy.json.JsonSlurper

// get key vault string
def key_vault_secret_id = "https://testkx.vault.azure.cn/secrets/test-getting-environment"
def get_key_vault_secret = """
  az keyvault secret show --id ${key_vault_secret_id} | jq -r '.value'
"""

def string = ["bash", "-c", get_key_vault_secret].execute().text



// Loop json
def jsonSlurper = new JsonSlurper()
assert jsonSlurper.parseText(string) instanceof ArrayList

def parser = new XmlParser()
def ServiceManifest = new XmlParser().parse(new File('ServiceManifest.xml'))

for (Map obj : jsonSlurper.parseText(string)) {
  def EnvironmentVariable = new Node(
    null, 
    new QName("EnvironmentVariable"), 
    [Name: "${obj.key}", Value: "${obj.value}"]
  )
  
  ServiceManifest.CodePackage.EnvironmentVariables[0].children().add(0, EnvironmentVariable)
}


FileWriter fileWriter = new FileWriter('save_file.xml')
XmlNodePrinter nodePrinter = new XmlNodePrinter(new PrintWriter(fileWriter))

nodePrinter.setPreserveWhitespace(true)
nodePrinter.print(ServiceManifest)
