FROM python:3
RUN pip install awscli
RUN apt-get install curl
RUN curl -LO "https://github.com/weaveworks/eksctl/releases/download/0.13.0/eksctl_Linux_amd64.tar.gz" && tar -xvzf eksctl_Linux_amd64.tar.gz -C /tmp && mv /tmp/eksctl /usr/local/bin
RUN curl -LO https://storage.googleapis.com/kubernetes-release/release/v1.15.0/bin/linux/amd64/kubectl && chmod +x ./kubectl && mv ./kubectl /usr/local/bin/kubectl
RUN curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3 && chmod +x ./get_helm.sh && ./get_helm.sh