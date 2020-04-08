import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { ACCENTIDADDVTService } from './accentidaddvt.service';
import { ACCENTIDADDVTDeleteDialogComponent } from './accentidaddvt-delete-dialog.component';

@Component({
  selector: 'jhi-accentidaddvt',
  templateUrl: './accentidaddvt.component.html'
})
export class ACCENTIDADDVTComponent implements OnInit, OnDestroy {
  aCCENTIDADDVTS?: IACCENTIDADDVT[];
  eventSubscriber?: Subscription;
  totalItems = 0;
  itemsPerPage = ITEMS_PER_PAGE;
  page!: number;
  predicate!: string;
  ascending!: boolean;
  ngbPaginationPage = 1;

  constructor(
    protected aCCENTIDADDVTService: ACCENTIDADDVTService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadPage(page?: number): void {
    const pageToLoad: number = page || this.page;

    this.aCCENTIDADDVTService
      .query({
        page: pageToLoad - 1,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe(
        (res: HttpResponse<IACCENTIDADDVT[]>) => this.onSuccess(res.body, res.headers, pageToLoad),
        () => this.onError()
      );
  }

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(data => {
      this.page = data.pagingParams.page;
      this.ascending = data.pagingParams.ascending;
      this.predicate = data.pagingParams.predicate;
      this.ngbPaginationPage = data.pagingParams.page;
      this.loadPage();
    });
    this.registerChangeInACCENTIDADDVTS();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IACCENTIDADDVT): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInACCENTIDADDVTS(): void {
    this.eventSubscriber = this.eventManager.subscribe('aCCENTIDADDVTListModification', () => this.loadPage());
  }

  delete(aCCENTIDADDVT: IACCENTIDADDVT): void {
    const modalRef = this.modalService.open(ACCENTIDADDVTDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.aCCENTIDADDVT = aCCENTIDADDVT;
  }

  sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected onSuccess(data: IACCENTIDADDVT[] | null, headers: HttpHeaders, page: number): void {
    this.totalItems = Number(headers.get('X-Total-Count'));
    this.page = page;
    this.router.navigate(['/accentidaddvt'], {
      queryParams: {
        page: this.page,
        size: this.itemsPerPage,
        sort: this.predicate + ',' + (this.ascending ? 'asc' : 'desc')
      }
    });
    this.aCCENTIDADDVTS = data || [];
  }

  protected onError(): void {
    this.ngbPaginationPage = this.page;
  }
}
