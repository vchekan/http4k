#!/bin/bash

source ./release-functions.sh

ensure_release_commit

maven_publish "http4k-core"
maven_publish "http4k-contract"
maven_publish "http4k-security-oauth"
maven_publish "http4k-cloudnative"
maven_publish "http4k-metrics-micrometer"

maven_publish "http4k-server-apache"
maven_publish "http4k-server-jetty"
maven_publish "http4k-server-netty"
maven_publish "http4k-server-undertow"

