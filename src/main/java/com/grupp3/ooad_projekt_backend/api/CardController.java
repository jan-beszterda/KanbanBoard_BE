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

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable("id") Long id) {
        return cardService.getCardById(id);
    }

    @PostMapping("/create")
    public Card addCard(@RequestBody Card card) {
        return cardService.addCard(card);
    }

    @DeleteMapping("/{id}")
    public void deleteCardById(@PathVariable("id") Long id) {
        cardService.removeCardById(id);
    }


    //move card from one column to another
    @PutMapping("/{cardId}/moveFrom/{columnId1}/to/{columnId2}")
    public void moveCard(@PathVariable("cardId") Long cardId, @PathVariable("columnId1") Long columnId1,
                         @PathVariable("columnId2") Long columnId2) {
        columnService.moveCard(cardId, columnId1, columnId2);
    }

}
