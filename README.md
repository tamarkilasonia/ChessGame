Chess Game Documentation
Overview
This Chess Game is an interactive application built with Java, designed to provide a fun and immersive chess-playing experience. It implements all standard chess rules and offers a clean, intuitive user interface for two players.

Features
Standard Chess Rules

Supports all piece movements: Pawn, Rook, Knight, Bishop, Queen, and King.
Includes special moves such as Castling, En Passant, and Pawn Promotion.
Game Mechanics

Detects Check, Checkmate, and Stalemate conditions.
Ensures valid move validation for all pieces.
User Interface

Visual representation of the chessboard and pieces.
Easy-to-use controls for selecting and moving pieces.
Option to restart the game at any time.
Future Enhancements (Planned)

AI opponent for single-player mode.
Timer for each player's moves.
Move history and undo functionality.
Project Structure
bash
Copy
Edit
Chess-Game/  
├── src/  
│   ├── board/           # Handles chessboard logic  
│   ├── pieces/          # Defines chess pieces and their movements  
│   ├── game/            # Main game logic  
│   ├── ui/              # User interface components  
│   └── Main.java        # Entry point of the application  
├── README.md            # Project description  
└── LICENSE              # License for the project  
