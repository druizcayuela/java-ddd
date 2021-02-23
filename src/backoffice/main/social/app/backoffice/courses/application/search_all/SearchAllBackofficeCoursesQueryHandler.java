package social.app.backoffice.courses.application.search_all;

import social.app.backoffice.courses.application.BackofficeCoursesResponse;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllBackofficeCoursesQueryHandler implements QueryHandler<SearchAllBackofficeCoursesQuery, BackofficeCoursesResponse> {
    private final AllBackofficeCoursesSearcher searcher;

    public SearchAllBackofficeCoursesQueryHandler(AllBackofficeCoursesSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public BackofficeCoursesResponse handle(SearchAllBackofficeCoursesQuery query) {
        return searcher.search();
    }
}
