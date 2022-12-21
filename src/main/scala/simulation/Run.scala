package simulation

import model.generics.{Generation, Life, Organism, TrialOutcome}

object Run {
  def life(
            organism: Organism,
            trial: Organism => TrialOutcome
          ): Life = ???

  def generation(
                  population: List[Organism],
                  trial: Organism => TrialOutcome
                ): Generation = ???

}