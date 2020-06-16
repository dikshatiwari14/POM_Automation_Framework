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
               stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('My SonarQube Server') {
                    // Optionally use a Maven environment you've configured already
                    withMaven(maven:'MAVEN_HOME') {
                        bat 'mvn clean package sonar:sonar'
                    }
                }
            }
        }
        
    }
}
