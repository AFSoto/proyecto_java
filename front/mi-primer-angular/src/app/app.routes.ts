import { Routes } from '@angular/router';
import { UserComponent } from './view/user/user.component/user.component';
import { PokemonComponent } from './view/pokemon/pokemon.component/pokemon.component';

export const routes: Routes = [
  {path:'',redirectTo:'users',pathMatch:'full'},
  {path:'users',component:UserComponent},
  {path:'pokemons',component:PokemonComponent},
];
