import hudson.model.JDK
import hudson.tools.JDKInstaller
import hudson.tools.InstallSourceProperty
import jenkins.model.Jenkins

def descriptor = new JDK.DescriptorImpl();

if (descriptor.getInstallations()) {
    println 'skip jdk installations'
} else {
    println 'add jdk8'
    Jenkins.instance.updateCenter.getById('default').updateDirectlyNow(true)
    def jdkInstaller = new JDKInstaller('jdk-8u121-oth-JPR', true)
    def jdk = new JDK("jdk8", null, [new InstallSourceProperty([jdkInstaller])])
    descriptor.setInstallations(jdk)
}
