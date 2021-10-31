pipeline {
    agent any
     
    stages {
        stage('Ok') {
            steps {
                echo "Okkkkkkkkk"
            }
        }
        //stage('Test Unitaire'){
        //    steps {
        //        bat 'mvn test';
        //    }
        //}
        //stage('Sonar'){
        //    steps {
        //        bat 'mvn sonar:sonar';
        //    }
        //}
        //stage('Nexus'){
        //    steps {
        //        bat 'mvn deploy';
        //    }
        //}
    }
    
    post {
        always {
            cleanWs()
        }
        success {
            mail bcc: '', 
            body: ''' Hey,
            The Build of your CiProject Pipeline was successful <3''', cc: '', from: '', replyTo: '', subject: 'Build successfull', to: 'amine.gongi@esprit.tn'
        }
        failure {
            mail bcc: '', 
            body: ''' Hey,
            The Build of your CiProject Pipeline has failed :(''', cc: '', from: '', replyTo: '', subject: 'Build Fail', to: 'amine.gongi@esprit.tn'
        }
    }
}
