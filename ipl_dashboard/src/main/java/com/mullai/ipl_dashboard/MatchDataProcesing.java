package com.mullai.ipl_dashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcesing implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcesing.class);

  @Override
  public Match process(final MatchInput matchInput) throws Exception {
    
    Match match = new Match();
    match.setId(Long.parseLong(matchInput.getId()));
    match.setCity(matchInput.getCity());
    match.setDate(LocalDate.parse(matchInput.getDate()));
    match.setPlayer_of_match(matchInput.getPlayer_of_match());
    match.setVenue(matchInput.getVenue());
    String fisrtInningsTeam, secondInningsTeam;
    if("bat".equals(matchInput.getToss_decision())){
      fisrtInningsTeam  = matchInput.getToss_winner();
      secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
    }else{
      secondInningsTeam  = matchInput.getToss_winner();
      fisrtInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
    }
    match.setTeam1(fisrtInningsTeam);
    match.setTeam2(secondInningsTeam);
    match.setToss_winner(matchInput.getToss_winner());
    match.setToss_decision(match.getToss_decision());
    match.setResult(matchInput.getResult();
    match.setResult_margin(matchInput.getResult_margin());
    match.setUmpire1(matchInput.getUmpire1());
    match.setUmpire2(matchInput.getUmpire2());
    
    return match;

 
  }

}