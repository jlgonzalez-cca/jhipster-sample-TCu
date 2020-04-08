import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { JhipsterSampleTCuSharedModule } from 'app/shared/shared.module';
import { JhipsterSampleTCuCoreModule } from 'app/core/core.module';
import { JhipsterSampleTCuAppRoutingModule } from './app-routing.module';
import { JhipsterSampleTCuHomeModule } from './home/home.module';
import { JhipsterSampleTCuEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    JhipsterSampleTCuSharedModule,
    JhipsterSampleTCuCoreModule,
    JhipsterSampleTCuHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    JhipsterSampleTCuEntityModule,
    JhipsterSampleTCuAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class JhipsterSampleTCuAppModule {}
