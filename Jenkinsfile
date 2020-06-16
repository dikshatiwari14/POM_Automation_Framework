pipeline
{
    agent any
    tools
    {
        maven 'MAVEN_HOME'
    }
    stages
    {
        stage('Checkout')
        {
            steps
            {
                Checkout scm
            }
        }
        stage('build')
        {
            steps
            {
                bat "mvn clean install"
            }
        }
    }
}
