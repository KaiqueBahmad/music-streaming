import { Component } from '@angular/core';
import { HeaderComponent } from '../../header/header.component';
import { ContentComponent } from '../../content/content.component';
import { FooterComponent } from '../../footer/footer.component';
import { PlayerBarComponent } from "../../components/player-bar/player-bar.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeaderComponent, ContentComponent, FooterComponent, PlayerBarComponent],
  template: `
  <div class="homepage">
    <app-header></app-header>
    <div class="content">
      <app-content></app-content>
    </div>
    <app-player-bar></app-player-bar>
  </div>
`,
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
