pipeline{

    agent any

    tools{maven 'MAVEN_HOME'}

    stages{

        stage('Checkout'){

            steps{

                git branch:'master',url:'https://github.com/AKASHMMM/User_Service2.git'

            }

        }

        stage('Build'){

            steps{

                bat 'mvn compile'

            }

        }

        stage('Test'){

            steps{

                bat 'mvn test'

            }

        }

        stage('Package'){

            steps{

                bat 'mvn package'

            }

        }

        stage('Deploy'){

            steps{

                echo 'deployed...'

            }

        }  

    }

}
