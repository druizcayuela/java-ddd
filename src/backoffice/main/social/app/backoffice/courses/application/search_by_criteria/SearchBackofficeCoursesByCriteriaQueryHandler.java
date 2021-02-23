package social.app.backoffice.courses.application.search_by_criteria;

import social.app.backoffice.courses.application.BackofficeCoursesResponse;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.query.QueryHandler;
import social.app.shared.domain.criteria.Filters;
import social.app.shared.domain.criteria.Order;

@Service
public final class SearchBackofficeCoursesByCriteriaQueryHandler implements QueryHandler<SearchBackofficeCoursesByCriteriaQuery, BackofficeCoursesResponse> {
    private final BackofficeCoursesByCriteriaSearcher searcher;

    public SearchBackofficeCoursesByCriteriaQueryHandler(BackofficeCoursesByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public BackofficeCoursesResponse handle(SearchBackofficeCoursesByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
