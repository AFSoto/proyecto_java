import { ChangeDetectorRef, Component } from '@angular/core';
import { PokemonService } from '../../../services/pokemon.service/pokemon.service';
import { PokemonInterface } from '../../../services/pokemon.service/pokemon.service';
@Component({
  selector: 'app-pokemon.component',
  imports: [],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css',
})
export class PokemonComponent {
  pokemons:PokemonInterface[] = [];

  constructor(private pokemonService:PokemonService,private chp: ChangeDetectorRef){
    this.pokemonService.getPokemons().subscribe(data =>{
      this.pokemons = data;
      console.log(data);
      this.chp.detectChanges();
    })
  }
}
