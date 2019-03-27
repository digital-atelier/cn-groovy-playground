import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()

def jsonText = '''[
  { 
    "name": "John Doe"
  },
  { 
    "name": "Karl Xu"
  }
]'''

def list = jsonSlurper.parseText(jsonText)

assert list instanceof ArrayList

for (Map obj : list) {
    println obj.name
}
