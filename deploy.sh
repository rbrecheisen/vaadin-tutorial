#!/bin/bash
docker buildx build --platform linux/amd64 -t brecheisen/myapp:latest .
docker login
docker push brecheisen/myapp:latest