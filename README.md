# PostRoll
A sample android app that displays a list of posts and shows details upon click. Data taken from [GraphQlZero](https://graphqlzero.almansi.me/).

| Author |  |
|--|--|
| Mina Kamel | Android Engineer  |

## Table of Contents
- [Post Roll](#post-roll)
    - [Table of Contents](#table-of-contents)
	- [Demo](#demo)
	- [Architecture](#architecture)
		- [The Data Layer](#the-data-layer)
		- [The Domain Layer](#the-domain-layer)
		- [The UI Layer](#the-ui-layer)
		- [Mappers and Objects](#mappers-and-objects)
		- [Utils and Extensions](#utils-and-extensions)
	- [Tests](#tests)
	- [Dependencies](#dependencies)

## Demo

<p align="center">
<img src="https://github.com/minafkamel/PostRoll/blob/master/demo.gif" alt="musically flow" width="400" height="800">


## Architecture

The app follows the concepts of [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) and uses the **Jetpack Compose** and **Android Architecture Components** to deliver its functionality. Each screen has a View Model to control it. 

The architecture is reactive. It uses **Coroutines/Flow** for domain and data layer and **MutableState** for the UI Layer. **Koin** is used for dependency injection due to its minimalistic set up.

### The Data Layer
The Data Layer relies on [Apollo](https://www.apollographql.com/docs/kotlin/) to deal with the graphQl API. Apollo generated classes: `GetPostDetailsQuery`and `GetAllPostsQuery`
corresponding to queries in `getallposts.graphql` and `getpostdetails.graphql` respectively.

- Queries:
  
| Method | Description
|--|--|
| `getallposts.graphql` | Queries `id`, `title` and `body` needed for the first screen
| `getpostdetails.graphql` | Queries `name` and `username` needed for the second screen (`title` and `body` could have been retrieved from that query as well however we cach them from first query to optimise network calls)

- Data Sources:  
  
| Class | Description
|--|--|
| `PostsRemoteDataSource` | Performs api calls, hence it's "remote"
| `PostsMemoryDataSourcel` | Provides a temporary caching mechanism to decrease network calls or reduce passing data between layers & through UI

  
- The `PostsRepository` has 2 methods:

| Method | Returns | Purpose
|--|--| --|
| `getAllPosts()` | GetAllPostsQuery.Data  | fetches the posts if `froceFetch` is true and caches the result via `PostsMemoryDataSource`. If false, then reads from memory 
| `getPostDetails()` | `GetPostDetailsQuery.Data` | Gets the details of the post however only username and name as we already have the title and body cached


### The Domain Layer
The Domain Layer contains use cases that do pieces of business logic. They are consumed by View Models in the UI Layer. The uses cases return a `Flow`.
  The domain layer should make sure data passed onwards to UI isn't null, therefore it does null checks (as an example here it was done in `GetPosts`) and also
  creates domain objects with non-nullable fields

Input and output: Usecases are generic in nature. This means they can receive custom types for `Param` and return a custom type for `Result`. In case no input is expected, `NoParams` is used. And in case no output is expected, `Nothing` is used. A `Params` in each use case is used to wrap input parameters.

| Use Case | Description | Input | Output |
|--|--|--|--|
| `GetPosts` | Calls `getAllPosts()` via `postsRepository` and returns a list of `Post` | `NoParams`| List of `GetPosts.Post` |
| `GetPostDetails` | Combines `postsRepository.getAllPosts` and `postsRepository.getPostDetails` to get details. `postsRepository.getAllPosts` is called this time with `forceFetch = false` because the data is cached from the first call | `Params(postId)`| List of `GetPostDetails.Details` |

### The UI Layer

  Each screen below has a view model that controls it. When the view model is done with logic it communicates via a `MutableState` that is a `UiState`.
  
|  | Description
|--|--|
| `MainActivity` | Holds `AllPostsScreen` and `DetailsScreen`
| `AllPostsScreen` - `AllPostsViewModel`| Displays a `LazyColumn` with all posts `PostView`. <br/> Has `TopBar` and `LoadingView` composables. On Click on a `PostView`, opens details
| `DetailsScreen` - `DetailsViewModel`| Displays `DetailsView` wich has 4 `Text()` composables. Also has `TopBar` and `LoadingView` composables.

### Mappers and objects
Each layer has a set of objects suited to its needs. The Domain Layer does the mapping in the use cases while the UI Layer uses mappers.
| Data | Domain | UI
|--|--|--|
| No mapping. Objects created by Apollo | Mapped in use cases. | Uses mappers to create models more suited to the UI displayed like string formatting. These entities have a `-ViewEntitiy` suffix to indicate they're view related. `PostsMapper` and `PostViewEntity` are examples |

### Utils & extensions
- `UiState`: A representation of loading and sucess state of the UI

### Tests
 As an example, I wrote a few tests: 
- Unit Tests: `GetPostDetails` in `GetPostDetailsTest` and `DetailsMapper` in `DetailsMapperTest`. 
	- The `whenever` statements are organised according to the `ArrangeBuilder` pattern. I've written about it [here](https://proandroiddev.com/tips-for-neater-android-development-part-1-34d3250b7943). This helps reusing statements and also turns them into english statements.
	- Tests are organised into Arrange, Act, and Assert(verify) blocks with a line break in between.
- UI/Compose Tests: `AllPostsScreenTest`


### Dependencies
All dependencies are organised in the `Dependencies.kt` files.
- Most important ones:
  - Jetpack Compose
  - Croutines
  - Apollo
  - Retrofit
  - Koin
