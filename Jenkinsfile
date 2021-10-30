pipeline {
    agent any
     
    stages {
        stage('Ok') {
            steps {
                echo "Okkkkkkkkk"
            }
        }
        //stage('Sonar'){
        //    steps {
        //        bat 'mvn sonar:sonar';
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
            The Build of your CiProject Pipeline was successful <3
            Thanks''', cc: '', from: '', replyTo: '', subject: 'Build successfull', to: 'amine.gongi@esprit.tn'
        }
        failure {
            mail bcc: '', 
            body: ''' Hey,
            The Build of your CiProject Pipeline has failed :(
            Thanks''', cc: '', from: '', replyTo: '', subject: 'Build Fail', to: 'amine.gongi@esprit.tn'
        }
    }
}
