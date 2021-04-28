pipeline {
  options {
    timeout(time: 15, unit: 'MINUTES')
  }
  environment {
    //put your own environment variables
    AWS_REGION = "ap-southeast-1"
    PROJECT = "dhamaka-pay"
    TAG = GIT_COMMIT.take(7)

  }
  agent {
    kubernetes {
      defaultContainer 'tools'
      yamlFile 'kubernetes/build.yaml'
    }
  }

  stages {
    stage('Pre Actions-Build Started') {
      steps {
        script {
            slackSend(
              color: '#F7A200',
              message: "Hey, CI/CD trigger has *Started* \n*Trigger: * `${env.JOB_NAME}` #${env.BUILD_NUMBER}\n<${env.BUILD_URL}/console|OPEN JENKINS BUILD>\n*GitHub: * ${GIT_BRANCH} >> <https://github.com/invariant-telecom/${PROJECT}/tree/${GIT_BRANCH}|Open Github>"
            )
        }
      }
    }

    stage('Docker Build') {
      steps {
        container('tools') {
          script {
            docker.withRegistry('https://906388694478.dkr.ecr.ap-southeast-1.amazonaws.com', 'ecr:ap-southeast-1:ecr') {
              def image = docker.build("${env.PROJECT}:${env.TAG}", "--network host .")
              //push image
              image.push()
            }
          }
        }
      }
    }

    stage('Deploy to develop') {
      when {
        branch 'develop'
      }
      steps {
        container('tools') {
          sh 'helm upgrade --install dhamaka-pay kubernetes/dhamaka-pay -f kubernetes/dhamaka-pay/develop-values.yaml --set image.tag=$TAG --namespace develop --atomic'
        }
      }
    }

    stage('Deploy to staging') {
      when {
        branch 'stage'
      }
      steps {
        container('tools') {
          sh 'helm upgrade --install dhamaka-pay kubernetes/dhamaka-pay -f kubernetes/dhamaka-pay/staging-values.yaml --set image.tag=$TAG --namespace staging --atomic'
        }
      }
    }

    stage('Deploy to production') {
      when {
        branch 'main'
      }
      steps {
        container('tools') {
          sh 'helm upgrade --install dhamaka-pay kubernetes/dhamaka-pay -f kubernetes/dhamaka-pay/production-values.yaml --set image.tag=$TAG --namespace production --atomic'
        }
      }
    }
  }
  post {
    success {
      slackSend(
        color: '#00FF00',
        message: "Hurray! CI/CD is *Success* \n*Trigger: * `${env.JOB_NAME}` #${env.BUILD_NUMBER}\n<${env.BUILD_URL}/console|OPEN JENKINS BUILD>\n*GitHub: * ${GIT_BRANCH} >> <https://github.com/invariant-telecom/${PROJECT}/tree/${GIT_BRANCH}|Open Github>"
      )
    }
    failure {
      slackSend(
        color: '#FF0000',
        message: "Oops, something's wrong; CI/CD *Failed* \n*Trigger: * `${env.JOB_NAME}` #${env.BUILD_NUMBER}\n<${env.BUILD_URL}/console|OPEN JENKINS BUILD>\n*GitHub: * ${GIT_BRANCH} >> <https://github.com/invariant-telecom/${PROJECT}/tree/${GIT_BRANCH}|Open Github>"
      )
    }
  }
}
