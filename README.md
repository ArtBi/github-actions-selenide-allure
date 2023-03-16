# github-actions-selenide-allure

[![Build Status](https://github.com/ArtBi/github-actions-selenide-allure/actions/workflows/chrome-test-execution.yml/badge.svg)](https://github.com/ArtBi/github-actions-selenide-allure/actions/workflows/chrome-test-execution.yml)

## Description

This project is an example of an automation test framework created to study the following technologies and how they may fit together.

## Technologies Used

* Java
* Gradle
* Selenide
* Allure Report
* GitHub Actions

## Requirements

* Java 11 or later
* Internet connection
* Installed Chrome Browser or [selenium/standalone-chrome](https://hub.docker.com/r/selenium/standalone-chrome/tags) docker image

## Installation

1. Clone the repository:
 ```sh
  git clone https://github.com/ArtBi/github-actions-selenide-allure.git
  ```

2. Build the project

* For running on local Chrome Browser:

```sh 
./gradlew clean build
```

3. If you want to run test into docker container:

```sh 
docker docker run --rm -it -p 4444:4444 -p 7900:7900 --shm-size 2g selenium/standalone-chrome:110.0
```

P.S. Use the following URL for watching your tests run in the docker:

```url 
http://localhost:7900/ 
```

Default password:

```pas 
secret
```

## Usage

1. Run the tests:

* For local run:

```sh 
./gradlew clean test allureReport
```

* For run into docker:

```sh 
./gradlew clean test -Dselenide.remote=http://localhost:4444/wd/hub allureReport
```
2. For oppening Allure Report page execute the following screept:
```sh 
build/allure/commandline/bin/allure serve --port 3333 \
   build/allure-results

```

## GitHub Actions

The project uses GitHub Actions for continuous integration. The workflow is defined in the ```.github/workflows/chrome-test-execution.yml``` file.

## GitHub Page

[![Allure Report Screen Shot](https://www.softwaretestingmagazine.com/wp-content/uploads/allure-e1613467667693.jpg)](https://artbi.github.io/github-actions-selenide-allure)


## Roadmap

- [x] Add GitHub Action
- [x] Add generation Allure Report as GitHub Page
- [ ] Add Jira integrations:
    - [ ] Add Jira TestCase links for each test 
    - [ ] Add the possibility of setting statuses for each test in the JIRA test suite




