pipeline
{
    agent any
    tools
    {
        maven 'MAVEN_HOME'
    }
    stages
    {
        stage('checkout')
        {
            steps
            {
                checkout scm
            }
        }
        stage('build')
        {
            steps
            {
                bat "mvn clean install"
            }
        }
        stage('Sonar Analysis')
        {
            steps
            {
                echo "Sonar"
                withSonarQubeEnv("local sonar")
                {
                 bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar"
                }
            }
        }
        
    }
}
