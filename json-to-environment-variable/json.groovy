import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()

def jsonText = '''[
  {
    "key": "DATABASE",
    "value": "mysql"
  },
  {
    "key": "DATABASE_HOST",
    "value": "localhost:3306"
  }
]'''

def list = jsonSlurper.parseText(jsonText)

assert list instanceof ArrayList

for (Map obj : list) {
  def command = """
    <EnvironmentVariable Name=\"${obj.key}\" Value=\"${obj.value}\"/>
  """
}
