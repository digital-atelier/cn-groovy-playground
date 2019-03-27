def test = new XmlSlurper().parse(new File('ServiceManifest.xml')) 

assert test instanceof groovy.util.slurpersupport.GPathResult 

println test.CodePackage.EntryPoint.ContainerHost.ImageName