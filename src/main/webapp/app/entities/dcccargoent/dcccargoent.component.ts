import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiParseLinks } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IDCCCARGOENT } from 'app/shared/model/dcccargoent.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { DCCCARGOENTService } from './dcccargoent.service';
import { DCCCARGOENTDeleteDialogComponent } from './dcccargoent-delete-dialog.component';

@Component({
  selector: 'jhi-dcccargoent',
  templateUrl: './dcccargoent.component.html'
})
export class DCCCARGOENTComponent implements OnInit, OnDestroy {
  dCCCARGOENTS: IDCCCARGOENT[];
  eventSubscriber?: Subscription;
  itemsPerPage: number;
  links: any;
  page: number;
  predicate: string;
  ascending: boolean;

  constructor(
    protected dCCCARGOENTService: DCCCARGOENTService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal,
    protected parseLinks: JhiParseLinks
  ) {
    this.dCCCARGOENTS = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.dCCCARGOENTService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe((res: HttpResponse<IDCCCARGOENT[]>) => this.paginateDCCCARGOENTS(res.body, res.headers));
  }

  reset(): void {
    this.page = 0;
    this.dCCCARGOENTS = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInDCCCARGOENTS();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IDCCCARGOENT): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInDCCCARGOENTS(): void {
    this.eventSubscriber = this.eventManager.subscribe('dCCCARGOENTListModification', () => this.reset());
  }

  delete(dCCCARGOENT: IDCCCARGOENT): void {
    const modalRef = this.modalService.open(DCCCARGOENTDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.dCCCARGOENT = dCCCARGOENT;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected paginateDCCCARGOENTS(data: IDCCCARGOENT[] | null, headers: HttpHeaders): void {
    const headersLink = headers.get('link');
    this.links = this.parseLinks.parse(headersLink ? headersLink : '');
    if (data) {
      for (let i = 0; i < data.length; i++) {
        this.dCCCARGOENTS.push(data[i]);
      }
    }
  }
}
