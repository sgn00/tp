package seedu.flashcard.model.flashcard;

import java.util.function.Predicate;

/**
 * Tests that a {@code Flashcard}'s {@code Category, Rating, isFavourite, Tags} matches any of the keywords given.
 */
public class MultipleFieldsEqualsKeywordsPredicate implements Predicate<Flashcard> {
    private final CategoryEqualsKeywordsPredicate categoryPredicate;
    private final RatingEqualsKeywordsPredicate ratingPredicate;
    private final FavouriteEqualsKeywordsPredicate favouritePredicate;
    private final TagsEqualKeywordsPredicate tagsPredicate;
    private final boolean isCategoryApplied;
    private final boolean isRatingApplied;
    private final boolean isFavouriteApplied;
    private final boolean isTagsApplied;

    /**
     * Creates MultipleFieldsEqualsKeywordsPredicate that contains specific predicates for category, rating
     * favourite and tags.
     */
    public MultipleFieldsEqualsKeywordsPredicate(CategoryEqualsKeywordsPredicate categoryPredicate,
                                                 RatingEqualsKeywordsPredicate ratingPredicate,
                                                 FavouriteEqualsKeywordsPredicate favouritePredicate,
                                                 TagsEqualKeywordsPredicate tagsPredicate) {
        this.categoryPredicate = categoryPredicate;
        this.ratingPredicate = ratingPredicate;
        this.favouritePredicate = favouritePredicate;
        this.tagsPredicate = tagsPredicate;
        this.isCategoryApplied = categoryPredicate.getCategory() != null;
        this.isRatingApplied = ratingPredicate.getRating() != null;
        this.isFavouriteApplied = favouritePredicate.getIsFavourite() != null;
        this.isTagsApplied = tagsPredicate.getTags() != null;
    }

    @Override
    public boolean test(Flashcard flashcard) {
        boolean categoryOutcome = true;
        boolean ratingOutcome = true;
        boolean favouriteOutcome = true;
        boolean tagsOutcome = true;
        if (isCategoryApplied) {
            categoryOutcome = categoryPredicate.test(flashcard);
        }
        if (isRatingApplied) {
            ratingOutcome = ratingPredicate.test(flashcard);
        }
        if (isFavouriteApplied) {
            favouriteOutcome = favouritePredicate.test(flashcard);
        }
        if (isTagsApplied) {
            tagsOutcome = tagsPredicate.test(flashcard);
        }
        return categoryOutcome && ratingOutcome && favouriteOutcome && tagsOutcome;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MultipleFieldsEqualsKeywordsPredicate // instanceof handles nulls
                && categoryPredicate.equals(((MultipleFieldsEqualsKeywordsPredicate) other).categoryPredicate)
                && ratingPredicate.equals(((MultipleFieldsEqualsKeywordsPredicate) other).ratingPredicate)
                && favouritePredicate.equals(((MultipleFieldsEqualsKeywordsPredicate) other).favouritePredicate)
                && tagsPredicate.equals(((MultipleFieldsEqualsKeywordsPredicate) other).tagsPredicate));
    }

}
