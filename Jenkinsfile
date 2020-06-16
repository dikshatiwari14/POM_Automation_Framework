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
         stage('build && SonarQube analysis') 
        {
            steps 
            {
                withSonarQubeEnv("local sonar")
                {
                        bat 'mvn clean package sonar:sonar'
                }
             }
         }
        
    }
}
