// Groovy execute cli

def command = '''
    az keyvault secret show --id https://testkx.vault.azure.cn//secrets//test-getting-environment | jq -r '.value'
'''

def p = ["bash", "-c", command].execute()
println p.text
