# Movie Streaming Platform Analytics Engine

A console-based movie analytics application developed using **Core Java 17** and the **Java Stream API**. The application analyzes movie details and viewing history using Java Collections, Streams, and Collectors without requiring a database or external infrastructure.

## Objective

The objective of this project is to demonstrate practical understanding of:

- Lambda expressions and method references
- Filtering and mapping data
- Sorting and limiting results
- Removing duplicates
- Processing nested collections using `flatMap()`
- Grouping and partitioning data
- Aggregation and reduction
- Working with `Optional`
- Primitive Streams
- Building meaningful Stream pipelines

## Technology Stack

- Java 17
- Java Stream API
- Java Collections Framework
- Collectors
- JUnit 5 for automated testing

## Project Structure

```text
Movie-Streaming-Platform-Analytics-Engine
│
├── src
│   ├── main
│   │   └── java
│   │       └── streamanalytics
│   │           ├── model
│   │           │   ├── Movie.java
│   │           │   └── ViewingRecord.java
│   │           ├── dto
│   │           │   └── MovieSummary.java
│   │           ├── data
│   │           │   └── SampleData.java
│   │           ├── service
│   │           │   ├── MovieAnalyticsService.java
│   │           │   └── ViewingAnalyticsService.java
│   │           └── Main.java
│   │
│   └── test
│       └── java
│
├── README.md
└── STREAM_EXPLANATION.md
```

## Data Models

### Movie

Represents a movie available on the fictional streaming platform.

| Field | Type |
|---|---|
| movieId | int |
| title | String |
| genres | List<String> |
| releaseYear | int |
| language | String |
| rating | double |
| durationMinutes | int |
| available | boolean |

### ViewingRecord

Represents an individual viewing session.

| Field | Type |
|---|---|
| sessionId | String |
| userId | int |
| movieId | int |
| minutesWatched | int |
| watchedOn | LocalDate |

## Sample Dataset

The application uses fixed sample data to ensure reproducible results.

The dataset includes:

- At least nine movies
- Multiple genres and languages
- Available and unavailable movies
- Multiple users and viewing dates
- Repeated viewing sessions
- Partial viewing sessions
- Movies with no viewing records

Movie durations and languages are documented in the sample dataset.

## Implemented Features

### Part A: Fundamental Stream Operations

**Problem 1 – Movie Filtering**

- Find movies rated at least 8.0
- Find movies released after 2020
- Find available Action movies
- Find movies longer than 120 minutes
- Find unavailable movies
- Find movies released within a specified year range

**Problem 2 – Mapping and Data Transformation**

- Extract movie titles
- Convert titles to uppercase
- Extract distinct release years
- Find titles containing more than ten characters
- Generate formatted movie descriptions
- Transform movies into `MovieSummary` DTOs

**Problem 3 – Sorting and Ranking**

- Sort movies alphabetically by title
- Sort by rating in descending order
- Find the top three highest-rated available movies
- Sort by release year in descending order
- Sort by rating and title for deterministic tie-breaking
- Find the second-highest distinct movie rating

### Part B: Intermediate Stream Operations

**Problem 4 – flatMap and Nested Data**

- Extract all genres
- Find unique genres in alphabetical order
- Count total genre assignments
- Find movies belonging to a specified genre
- Identify genres appearing in multiple movies

**Problem 5 – Grouping and Partitioning**

- Group movies by language
- Count movies by release year
- Calculate average rating by language
- Group movies by availability
- Partition movies by rating
- Group movie titles by release year
- Group movies by genre

**Problem 6 – Map Creation and Duplicate Handling**

- Create a Map using movie IDs
- Create Maps containing movie titles and ratings
- Create Maps containing movie titles and release years
- Demonstrate duplicate-key handling
- Apply a merge strategy for duplicate movie titles

Duplicate-title resolution follows the assignment rules:

1. Retain the movie with the higher rating.
2. If ratings are equal, retain the more recently released movie.
3. If both are equal, retain the movie with the smaller ID.

### Part C: Advanced Data Processing

**Problem 7 – Viewing History Analytics**

- Calculate total viewing minutes per user
- Find the user with the highest viewing time
- Count viewing sessions per movie
- Find the most-watched movie based on total minutes
- Find unique movie IDs viewed by a user
- Identify movies with no viewing records
- Group viewing records by date
- Associate viewing records with movie details

Tie-breaking rules:

- For users with equal viewing minutes, select the smaller user ID.
- For movies with equal viewing minutes, select the smaller movie ID.

**Problem 8 – reduce, Summary Statistics and Optional**

- Calculate total viewing minutes using `reduce()`
- Calculate total movie duration using primitive Streams
- Find average, highest, and lowest movie ratings
- Obtain duration statistics using `IntSummaryStatistics`
- Find movies by ID
- Handle missing movies safely
- Find the highest-rated available movie
- Use `Optional` to handle operations that may not produce a result

### Part D: Challenging Problems

**Problem 9 – Movie Recommendation Engine**

Recommend movies based on user preferences.

The recommendation engine:

- Recommends only available movies
- Matches at least one preferred genre
- Excludes movies below the minimum rating
- Sorts by rating in descending order
- Uses release year in descending order to break rating ties
- Returns no more than the requested limit
- Avoids duplicate recommendations
- Handles empty genre preferences and invalid limits

**Problem 10 – Stream Pipeline Debugging**

Analyze and correct a Stream pipeline that attempts to reuse a Stream after a terminal operation.

The problem demonstrates:

- Stream consumption
- Intermediate and terminal operations
- Lazy evaluation
- Correct Stream reuse practices

## Technical Restrictions

- Java 17 is mandatory.
- No Spring Boot.
- No database.
- No third-party data-processing libraries.
- Required filtering, mapping, sorting, grouping, and aggregation must use the Stream API.
- Traditional loops may be used for sample data initialization and console input.
- Avoid modifying external collections or mutable variables inside Stream operations.
- Do not reuse a Stream after a terminal operation.
- Avoid using `peek()` for business-logic side effects.
- Handle empty collections and missing results safely.
- Prioritize readability and correctness over unnecessarily long Stream pipelines.

## Setup and Execution

### Prerequisites

- Java Development Kit (JDK) 21
- IntelliJ IDEA or another Java IDE

### Run the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/Neha-Mukherjee/Movie-Streaming-Platform-Analytics-Engine-Stream-Api-practice-.git
   ```

2. Open the project in IntelliJ IDEA.
3. Configure the project SDK to Java 17.
4. Locate `Main.java`.
5. Run the `main()` method.

The application uses predefined sample data and does not require a database or external services.

