def snippet = '''
<EnvironmentVariables>
    <EnvironmentVariable Name="MyEnvVariable" Value="DefaultValue"/>
    <EnvironmentVariable Name="HttpGatewayPort" Value="19080"/>
</EnvironmentVariables>
'''


def test = new XmlSlurper().parseText(snippet) 

assert test instanceof groovy.util.slurpersupport.GPathResult 

println test.EnvironmentVariable[0]['@Name']
