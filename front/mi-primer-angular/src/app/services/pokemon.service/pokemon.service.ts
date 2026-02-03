import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export interface PokemonResponse{
  count:number;
  next:string | null;
  previous:string;
  results: PokemonInterface[]
}

export interface PokemonInterface{
  name: string;
  url: string;
}
@Injectable({
  providedIn: 'root',
})
export class PokemonService {
  constructor(private http: HttpClient){}

  getPokemons(){
    return this.http.get<PokemonResponse>('https://pokeapi.co/api/v2/pokemon?limit=8')
  }

}
