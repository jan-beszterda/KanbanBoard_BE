package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Card;
import com.grupp3.ooad_projekt_backend.service.CardService;
import com.grupp3.ooad_projekt_backend.service.ColumnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {

    private CardService cardService;
    private ColumnService columnService;

    public CardController(CardService cardService, ColumnService columnService) {
        this.cardService = cardService;
        this.columnService = columnService;
    }

    @GetMapping()
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{card_id}")
    public Card getCardById(@PathVariable("card_id") Long id) {
        return cardService.getCardById(id);
    }

    @PostMapping("/create")
    public Card addCard(@RequestParam("creator_id") Long userId, @RequestParam("column_id") Long columnId, @RequestBody Card card) {
        return cardService.addCard(userId, columnId, card);
    }

    @DeleteMapping("/{card_id}")
    public void deleteCardById(@PathVariable("card_id") Long id) {
        cardService.removeCardById(id);
    }


    @PutMapping("/{card_id}/move")
    public void moveCard(@PathVariable("card_id") Long cardId, @RequestParam("from") Long columnId1,
                         @RequestParam("to") Long columnId2) {
        columnService.moveCard(cardId, columnId1, columnId2);
    }

}
