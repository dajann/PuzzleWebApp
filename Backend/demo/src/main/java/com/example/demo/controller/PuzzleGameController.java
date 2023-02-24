package com.example.demo.controller;



import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.controller.model.PuzzleGame;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PuzzleGameController {

	private PuzzleGame game;
	public PuzzleGameController() {
		game = new PuzzleGame();
	}
	
	@PostMapping("/update")
	public ResponseEntity<Integer[]> createResult(@RequestBody Map<String, Integer> requestBody) {
	    int x = requestBody.get("x");
	    switch(x) {
	      case 0:
	    	  game.button0Action(x);
	        break;
	      case 1:
	    	  game.button1Action(x);
	        break;
	      case 2:
	    	  game.button2Action(x);
	        break;
	      case 3:
	    	  game.button3Action(x);
	        break;
	      case 4:
	    	  game.button4Action(x);
	        break;
	      case 5:
	    	  game.button5Action(x);
	        break;
	      case 6:
	    	  game.button6Action(x);
	        break;
	      case 7:
	    	  game.button7Action(x);
	        break;
	      case 8:
	    	  game.button8Action(x);
	        break;
	      case 9:
	    	  game.button9Action(x);
	        break;
	      case 10:
	    	  game.button10Action(x);
	        break;
	      case 11:
	    	  game.button11Action(x);
	        break;
	      case 12:
	    	  game.button12Action(x);
	        break;
	      case 13:
	    	  game.button13Action(x);
	        break;
	      case 14:
	    	  game.button14Action(x);
	        break;
	      case 15:
	    	  game.button15Action(x);
	        break;
	      
	    }
		return ResponseEntity.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(game.buttons);
	}
	
	@GetMapping("/table")
	public Integer[] getTable() {
		return game.buttons;
	}
	@GetMapping("/restart")
	public Integer[] restart() {
		do{
            game.buttons = game.createShuffleArray();
            game.expand(game.buttons);
        }while(!game.isSolvable());
		return game.buttons;
	}
	@GetMapping("/end")
	public Boolean hello() {
		return game.checkWin();
	}
}
