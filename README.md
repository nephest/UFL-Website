# UFL Website

`UFL Website` is a React/Spring app for StarCraft 2 tournaments.

## Installation

### Frontend
1. Install the [React](https://nodejs.org/) recommended version.
2. Run the following command lines in the project path:
    + `npm install`
    + `npm start`

### Backend
[Gradle](https://gradle.org/) build tool is used for backend and general build tasks. 
#### Wrapper
You can use gradle wrapper if you don't want to install it. The following commands are interchangeable.
* `gradlew` for linux
* `gradlew.bat` for windows
* `gradle` to run gradle without the wrapper

#### Running
Default port is 8080.
* `gradle clean bootRun` to run the backend in headless mode.
* `gradle clean bootRun -PbuildProfile=front` to run the backend in production mode. The frontend will be compiled and packaged
   via node-plugin.

#### Testing
`gradle clean verify -PbuildProfile=front` to run the entire build chain including tests.

#### Node-plugin
[gradle-node-plugin](https://github.com/node-gradle/gradle-node-plugin) is used as a front-end plugin for gradle.
Use [build.gradle](server/build.gradle) (`node` section) config if you need to configure node settings. See 
[plugin usage guide](https://github.com/node-gradle/gradle-node-plugin/blob/master/docs/usage.md#configuring-the-plugin)
for more details.

## License
[MIT](https://choosealicense.com/licenses/mit/)