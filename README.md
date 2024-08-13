KayakCase
For MacOS

1. Install Homebrew

Please paste this into Terminal. /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)" Once homebrew has completed installing itself, double check your work. brew update && brew doctor

2. Install Specific Versions of Java

brew tap adoptopenjdk/openjdk brew cask install adoptopenjdk11 Verify Your Work brew info java

3. Install Latest Maven

brew install maven Once maven has completed installing itself, double check your work. mvn -v

For Windows

1. Install Java

Go to link below to download and install specific version of jdk (11) https://www.oracle.com/java/technologies/javase-downloads.html

2. Set Environment Variables in Java: Path and Classpath

Right Click on the My Computer and Select the properties Click on advanced system settings Click on Environment Variables Click on new Button of User variables Type PATH in the Variable name. Copy the path of bin folder which is installed in JDK folder. Paste Path of bin folder in Variable value and click on OK Button. Note: In case you already have a PATH variable created in your PC, edit the PATH variable to PATH = \bin;%PATH%; You can follow a similar process to set CLASSPATH. Note: In case you java installation does not work after installation, change classpath to CLASSPATH = \lib\tools.jar; Click on OK button Go to command prompt and type javac commands.

3. Install Maven

Download maven https://kozyatagi.mirror.guzel.net.tr/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip unzip apache-maven-3.6.3-bin.zip Adding to PATH: Add the unpacked distribution’s bin directory to your user PATH environment variable by opening up the system properties (WinKey + Pause), selecting the “Advanced” tab, and the “Environment Variables” button, then adding or selecting the PATH variable in the user variables with the value C:\Program Files\apache-maven-3.6.3\bin. The same dialog can be used to set JAVA_HOME to the location of your JDK, e.g. C:\Program Files\Java\jdk1.7.0_51 Open a new command prompt (Winkey + R then type cmd) and run mvn -v to verify the installation.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

In my project, I handle reporting by taking screenshots at the point of failure, which are saved in the target>screenshots>failure directory. 
Automatic driver downloads are managed in the DriverFactory class. Although I am not using the latest versions of the drivers due to stability issues, these versions are included as comments.
The project is set up to run in Docker, and this configuration is also specified in the DriverFactory class. 
I have written the project using Cucumber and strive to adhere to the necessary principles.
