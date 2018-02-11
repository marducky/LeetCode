# Install kubectl binary via curl
## step
```
Download the latest release with the command:
curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
To download a specific version, replace the $(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt) portion of the command with the specific version.
For example, to download version v1.9.0 on Linux, type:
curl -LO https://storage.googleapis.com/kubernetes-release/release/v1.9.0/bin/linux/amd64/kubectl
Make the kubectl binary executable.
 chmod +x ./kubectl
Move the binary in to your PATH.
 sudo mv ./kubectl /usr/local/bin/kubectl

```
>资料文档<br>
https://github.com/kubernetes/kubernetes
[k8s kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)